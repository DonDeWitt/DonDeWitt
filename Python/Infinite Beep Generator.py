#Infinite Beep Generator is a program exploring generative synthesis using the winsound.beep function available in Python on Windows machines.
#The user can select a length for beeps and any amount of musical keys.
#Program by Donald DeWitt
import winsound
from random import *

#Function for making a beep with a random frequency
def randomBeep(ms):
    p=randint(200,800)
    winsound.Beep(int(p),int(ms))

#Function for making a beep within a specified musical key
def keyBeep(keys, key, ms):
    r = randint(0,7)
    winsound.Beep(keys[key][r],int(ms))

#Iterative function for making an infinite series of beeps using user input
def playSound(chosenkeys, keys, ms):
    #Condition is always true, as the program is an INFINITE beep generator
    while(True):
        for key in chosenkeys:
            if(key == 'random'):
                randomBeep(ms)
            else:
                keyBeep(keys, key, ms)

#Function for printing dictionary keys (to avoid unnesecary code duplication)
def iterate(x):
    for i in x:
        print(i)

def main():
    print("Infinite Beep Generator \nBy Donald DeWitt\n")

    #endLoop is a boolean value to determine if the current loop should break
    endLoop = False

    #Loop for getting the length of each beep and validating user input
    while(not endLoop):
        #ms is milliseconds
        ms = input("How long do you want each beep to sound in milliseconds? (1000 milliseconds = 1 second): ")
        #Exception handler in case the user enters a character or string
        try:
            ms = int(ms)
        except ValueError:
            #Sets ms to -1 if the user enters a non-integer value
            ms = -1
        #Check if ms is larger than 1, so that we have an integer that will work
        if(ms > 0):
            endLoop = True
        else:
            print("Invalid input. Please enter a whole number integer greater than 0.")

    #Dictionary of available music keys, each must have a list of 8 unless the indexes are not used, as in the case of the random key     
    keys =  {
            'c'          :[261, 293, 329, 349, 392, 440, 493, 523],
            'a'          :[440, 493, 554, 587, 659, 740, 830, 880],
            'b'          :[493, 554, 622, 659, 740, 830, 932, 987],
            'e'          :[329, 370, 415 ,440 ,493, 554, 659, 1318],
            'pentatonic' :[277, 311, 370, 415, 466, 554, 622, 740],
            'random'     :[0]
            }
    #List of available keys for dynamically informing user of available keys
    listkeys = list(keys.keys())
    #List of keys chosen by the user
    chosenkeys = []

    #Loop for getting the key 1 of each beep and validating user input
    endLoop = False
    while(not endLoop):
        #Prompt the user to select a key. Inform the user what keys are available
        if(len(chosenkeys) == 0):
            print("Please choose from the following keys:")
            iterate(keys)
            key = input("In what key do you want the beeps to be? ").lower()
        else:
            key = input("Would you like the beeps to be in any additional keys? If yes, enter the the key name. Otherwise, enter [n]o? ").lower()

        #Add the entered key into chosenkeys[], end the loop if user enters [n]o, or prompt the user if the input is invalid
        if(key in keys):
           chosenkeys.append(key)
        elif((len(chosenkeys) > 0)and(key == 'n' or key == 'no')):
            endLoop = True
        else:
            print("Invalid input. Please enter one of the listed keys.")

    #Displays the information the user entered
    print("Your beeps will be " + str(ms) + " milliseconds long and will be in the key(s) of")
    iterate(chosenkeys)
    enter = input("Press enter to recieve your beeps.")
    #Let the user know the beeps will commence now
    print("\n" + "Beeping...")
    playSound(chosenkeys, keys, ms)

main()
