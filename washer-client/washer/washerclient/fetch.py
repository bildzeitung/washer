"""
    Single-shot methods to retrieve metadata
"""
import json

from trio_websocket import open_websocket_url


async def get_worlds():
    """ Retrieve a list of worlds from the server
    """
    async with open_websocket_url("ws://localhost:1234") as ws:
        s = {"verb": "get", "type": "worlds",
             "location": {"x": 0, "y": 0, "z": 0}}
        await ws.send_message(json.dumps(s))
        return await ws.get_message()