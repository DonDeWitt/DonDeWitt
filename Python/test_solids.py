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
    def test_volume(self):
        self.assertAlmostEqual(getCubeVolume(1), 1)
        self.assertAlmostEqual(getCubeVolume(0), 0)
        self.assertAlmostEqual(getCubeVolume(2), 8)

    def test_values(self):
        self.assertRaises(ValueError, getCubeVolume, -2)

    def test_types(self):
        self.assertRaises(TypeError, getCubeVolume, True)
        self.assertRaises(TypeError, getCubeVolume, "height")

class TestSphereArea(unittest.TestCase):
    def test_area(self):
        self.assertAlmostEqual(getSphereArea(0), 0)
        self.assertAlmostEqual(getSphereArea(1), 12.566370614359172)

    def test_values(self):
        self.assertRaises(ValueError, getSphereArea, -2)

    def test_types(self):
        self.assertRaises(TypeError, getSphereArea, True)
        self.assertRaises(TypeError, getSphereArea, "height")

class TestSphereVolume(unittest.TestCase):
    def test_volume(self):
        self.assertAlmostEqual(getSphereVolume(0), 0)
        self.assertAlmostEqual(getSphereVolume(1), ((4/3) * pi * (1 ** 3)))

    def test_values(self):
        self.assertRaises(ValueError, getSphereVolume, -2)

    def test_types(self):
        self.assertRaises(TypeError, getSphereVolume, True)
        self.assertRaises(TypeError, getSphereVolume, "height")

class TestCylinderArea(unittest.TestCase):
    def test_area(self):
        self.assertAlmostEqual(getCylinderArea(0,0), 0)
        self.assertAlmostEqual(getCylinderArea(1,1), ((6.28*1*1)+(6.28*(1 ** 2))))

    def test_values(self):
        self.assertRaises(ValueError, getCylinderArea, -2, -1)

    def test_types(self):
        self.assertRaises(TypeError, getCylinderArea, True, False)
        self.assertRaises(TypeError, getCylinderArea, "height", "radius")

class TestCylinderVolume(unittest.TestCase):
    def test_volume(self):
        self.assertAlmostEqual(getCylinderVolume(0,0), 0)
        self.assertAlmostEqual(getCylinderVolume(1,1), (3.14*(1 ** 2)*1))

    def test_values(self):
        self.assertRaises(ValueError, getCylinderVolume, -2, -2)

    def test_types(self):
        self.assertRaises(TypeError, getCylinderVolume, True, False)
        self.assertRaises(TypeError, getCylinderVolume, "height", "radius")

