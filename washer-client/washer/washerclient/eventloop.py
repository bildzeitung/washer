"""
    Main event loop class
"""
import json
import logging
from trio_websocket import open_websocket_url

logging.basicConfig(level=logging.DEBUG)


class Washer:
    """
        Event loop
    """
    def __init__(self):
        self.move_callbacks = []
        self._ws = None

    def register_move_callback(self, callback):
        self.move_callbacks.append(callback)

    async def process_message(self, msg):
        m = json.loads(msg)
        logging.debug(f'Received |{m}|')
        for b in self.move_callbacks:
            await b(self, m)

    async def run(self):
        try:
            async with open_websocket_url("ws://localhost:1234") as ws:
                self._ws = ws
                while True:
                    msg = await ws.get_message()
                    await self.process_message(msg)
        except OSError:
            print("Cannot connect to minecraft")

    async def block_set(self, location):
        s = {"verb": "set", "type": "block", "location": location}
        await self._ws.send_message(json.dumps(s))
        logging.debug(f"Sent |{s}|")
