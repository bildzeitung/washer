import json
import logging
import trio
from trio_websocket import open_websocket_url

logging.basicConfig(level=logging.DEBUG)


async def main():
    async with open_websocket_url("ws://localhost:1234") as ws:
        s = {"verb": "get", "type": "worlds",
             "location": {"x": 0, "y": 0, "z": 0}}
        await ws.send_message(json.dumps(s))
        print(await ws.get_message())


def cli():
    trio.run(main)
