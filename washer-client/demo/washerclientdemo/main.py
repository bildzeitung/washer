"""
    Demo application for Washer

    Do a Tron-type thing where blocks are placed where hte player just was

"""
from washerclient import Washer
import trio


async def move_callback(washer, m):
    await washer.block_set(m["from"])


async def main():
    w = Washer()
    w.register_move_callback(move_callback)
    await w.run()


def cli():
    trio.run(main)
