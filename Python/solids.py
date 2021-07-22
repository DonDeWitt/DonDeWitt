from math import pi

def getCubeArea(height):
    '''input variable must be positive int or float'''
    if type(height) not in [int, float]:
        raise TypeError("The height must be a non-negative real number.")
    if height < 0:
        raise ValueError("The height must be positive")
    return (6 * height ** 2)

def getCubeVolume(height):
    '''input variable must be positive int or float'''
    if type(height) not in [int, float]:
        raise TypeError("The height must be a non-negative real number.")
    if height < 0:
        raise ValueError("The height must be positive.")
    return (height ** 3)

def getSphereArea(radius):
    '''input variable must be positive int or float'''
    if type(radius) not in [int, float]:
        raise TypeError("The radius must be a non-negative real number.")
    if radius < 0:
        raise ValueError("The radius must be positive.")
    return (4*(pi*(radius ** 2)))

def getSphereVolume(radius):
    '''input variable must be positive int or float'''
    if type(radius) not in [int, float]:
        raise TypeError("The radius must be a non-negative real number.")
    if radius < 0:
        raise ValueError("The radius must be positive.")
    return ((4/3) * pi * (radius ** 3))

def getCylinderArea(height, radius):
    '''input variable must be positive int or float'''
    if type(radius) not in [int, float] or type(height) not in [int, float]:
        raise TypeError("The radius and height must be non-negative real numbers.")
    if radius < 0 or height < 0:
        raise ValueError("The radius and height must be positive.")
    return ((6.28*radius*height)+(6.28*(radius ** 2)))

def getCylinderVolume(height, radius):
    '''input variable must be positive int or float'''
    if type(radius) not in [int, float] or type(height) not in [int, float]:
        raise TypeError("The radius and height must be non-negative real numbers.")
    if radius < 0 or height < 0:
        raise ValueError("The radius and height must be positive.")
    return (3.14*(radius ** 2)*height)

