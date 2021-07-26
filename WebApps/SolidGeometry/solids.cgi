#! /usr/bin/python3

# solids.cgi - do math on solid geometry
#
# D DeWitt, 20 Nov 2020

import cgi
import cgitb
cgitb.enable(format='text')

print('Access-Control-Allow-Origin: *')
print('Content-type: text/plain')
print()

#print('Here is the data you sent:')

formdata = cgi.FieldStorage()

#for key in sorted(formdata.keys()):
  #print(key + '->' + formdata.getvalue(key))
  
if formdata.getvalue('solid') == 'cube':
  height = float(formdata.getvalue('height'))
  if formdata.getvalue('area') == 'on':
    print('A cube with height ',height, ' has the surface area ', 6 * height ** 2)
  if formdata.getvalue('volume')== 'on':
    print('A cube with height ',height, ' has the volume ', height ** 3)


if formdata.getvalue('solid') == 'sphere':
  radius = float(formdata.getvalue('radius'))
  if formdata.getvalue('area') == 'on':
    print('A sphere with radius ',radius, ' has the surface area ', 4*(3.14*(radius ** 2)))
  if formdata.getvalue('volume')== 'on':
    print('A sphere with radius ',radius, ' has the volume ', (4/3)*3.14*(radius ** 3))
    
if formdata.getvalue('solid') == 'cylinder':
  radius = float(formdata.getvalue('radius'))
  height = float(formdata.getvalue('height')) 
  if formdata.getvalue('area') == 'on':
    print('A cylinder with height ',height, ' and radius ', radius,' has the surface area ', (6.28*radius*height)+(6.28*(radius ** 2)) )
  if formdata.getvalue('volume')== 'on':
    print('For a cylinder with height ',height, ' and radius ', radius,' has the volume ',3.14*(radius ** 2)*height)   