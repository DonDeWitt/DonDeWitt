from math import pi
import unittest
from solids import *

class TestCubeArea(unittest.TestCase):
    def test_area(self):
        self.assertAlmostEqual(getCubeArea(1), 6)
        self.assertAlmostEqual(getCubeArea(0), 0)

    def test_values(self):
        self.assertRaises(ValueError, getCubeArea, -2)

    def test_types(self):
        self.assertRaises(TypeError, getCubeArea, True)
        self.assertRaises(TypeError, getCubeArea, "height")

class TestCubeVolume(unittest.TestCase):
    def test_area(self):
        self.assertAlmostEqual(getCubeVolume(1), 1)
        self.assertAlmostEqual(getCubeVolume(0), 0)
        self.assertAlmostEqual(getCubeVolume(2), 8)

    def test_values(self):
        self.assertRaises(ValueError, getCubeVolume, -2)

    def test_types(self):
        self.assertRaises(TypeError, getCubeVolume, True)
        self.assertRaises(TypeError, getCubeVolume, "height")
