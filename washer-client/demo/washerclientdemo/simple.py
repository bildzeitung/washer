import logging
import trio
from washerclient import get_worlds

logging.basicConfig(level=logging.DEBUG)


async def main():
    worlds = await get_worlds()
    main_world = worlds[0]  # don't know if this can be assumed, but ...
    print(f"MAIN WORLD IDENTIFIER: {main_world}")


def cli():
    trio.run(main)
