from math import pi

def getCubeArea(height):
    if type(height) not in [int, float]:
        raise TypeError("The height must be a non-negative real number.")
    if height < 0:
        raise ValueError("The height must be positive")
    return (6 * height ** 2)

def getCubeVolume(height):
    if type(height) not in [int, float]:
        raise TypeError("The height must be a non-negative real number.")
    if height < 0:
        raise ValueError("The height must be positive.")
    return (height ** 3)

def getSphereRadius(radius):
    if type(radius) not in [int, float]:
        raise TypeError("The radius must be a non-negative real number.")
    if radius < 0:
        raise ValueError("The radius must be positive.")
    return (4*(pi*(radius ** 2)))

def getSphereVolume(radius):
    return ((4/3) * pi * (radius ** 3))

'''
if formdata.getvalue('solid') == 'cylinder':
  radius = float(formdata.getvalue('radius'))
  height = float(formdata.getvalue('height')) 
  if formdata.getvalue('area') == 'on':
    print('A cylinder with height ',height, ' and radius ', radius,' has the surface area ', (6.28*radius*height)+(6.28*(radius ** 2)) )
  if formdata.getvalue('volume')== 'on':
    print('For a cylinder with height ',height, ' and radius ', radius,' has the volume ',3.14*(radius ** 2)*height)
'''
