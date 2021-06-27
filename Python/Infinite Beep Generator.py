#Beep keys is a program exploring generative synthesis using the winsound.beep function available in Python on Windows machines.
#The user can select a length for beeps and up to 3 different keys.
#Program by Donald DeWitt
import winsound
from random import *

print("Infinite Beep Generator \nBy Donald DeWitt\n")

#CorrectInput is a boolean value to determine if the user entered correct input
correctInput = False;

#Loop for getting the length of each beep and validating user input
while(not correctInput):
    ms = input("How long do you want each beep to sound in milliseconds? (1000 milliseconds = 1 second): ")
    #Exception handler in case the user enters a character or string
    try:
        ms = int(ms)
    except ValueError:
        #Sets ms to -1 if the user enters a non-integer value
        ms = -1
    #Check if ms is larger than 1, so that we have an integer that will work
    if(ms > 0):
        correctInput = True
    else:
        print("Invalid input. Please enter a whole number integer greater than 0.")

#Dictionary of available keys     
keys =  {
        'c'          :[261, 293, 329, 349, 392, 440, 493, 523],
        'a'          :[440, 493, 554, 587, 659, 740, 830, 880],
        'b'          :[493, 554, 622, 659, 740, 830, 932, 987],
        'e'          :[329, 370, 415 ,440 ,493, 554, 659, 1318],
        'pentatonic' :[277, 311, 370, 415, 466, 554, 622, 740],
        'random'     :[0]
        }

#Loop for getting the key 1 of each beep and validating user input
correctInput = False
while(not correctInput):
    print("Please choose from the following keys:\n\tRandom \n\tA \n\tB \n\tC \n\tE \n\tBlack Keys")
    key = input("In what key do you want the beeps to be? ").lower()
    if(key in keys):
       correctInput = True
    else:
        print("Invalid input. Please enter one of the listed keys.")

correctInput = False
key2 = ' '
key3 = ' '
    
other1 = input("Would you like the beeps to be in any additional keys? [Y]es or [N]o? ").lower()

#Loop for getting the key 2 of each beep and validating user input
if ((other1 == 'y') | (other1 == 'yes')):
    other1 = 'y'
    while(not correctInput):
        key2 = input("In what other key do you want the beeps to be?").lower()
        if(key2 in keys):
            correctInput = True
        else:
            print("Invalid input. Please enter one of the listed keys.")

correctInput = False
if(other1 == 'y'):
    other2 = input("Would you like the beeps to be in one more key? [Y]es or [N]o? ").lower()
    if ((other2 == 'y') | (other2 == 'yes')):
        while(not correctInput):
            key3 = input("In what other key do you want the beeps to be?").lower()
            if(key3 in key):
                correctInput = True
            else:
                print("Invalid input. Please enter one of the listed keys.")
else:
    other2 = 'n'

#Displays the information the user entered
readyinput = input("Your beeps will be " + str(ms) +
                   " milliseconds long and will be in the key(s) of" + "\n" +
                   key + "\n" +
                   key2 + "\n" +
                   key3 + "\n" +
                   "Press enter to recieve your beeps.")

#Let the user know the beeps will commence now
print("\n" + "Beeping...")

#Function for making a beep with a random frequency
def randomBeep():
    p=randint(200,800)
    winsound.Beep(int(p),int(ms))

#Function for making a beep within a specified musical key
def keyBeep(key, ms):
    r = randint(0,7)
    winsound.Beep(keys[key][r],int(ms))

#Recursive function for making an infinite series of beeps using user input
def playSound():
    if key == 'random':
        randomBeep()
    else:
        keyBeep(key, ms)
    if (other1 == 'y'):
        if(key2=='random'):
           randomBeep()
        else:
            keyBeep(key2, ms)
        if (other2 == 'y'):
            if(key3=='random'):
                randomBeep()
            else:
                keyBeep(key3, ms)
    playSound()

#Start beeping
playSound()
