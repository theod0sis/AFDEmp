oneDigit = input("Please, enter a number with one digit")
twoDigit = input("Please, enter a number with two digits")
threeDigit = input("Please, enter a number with three digits")
oneSDigit = input("Please, enter a second number with one digit")
twoSDigit = input("Please, enter a second number with two digits")
threeSDigit = input("Please, enter a second number with three digits")
oneTDigit = input("Please, enter a third number with one digit")
twoTDigit = input("Please, enter a third number with two digits")
threeTDigit = input("Please, enter a third number with three digits")
oneDigitL = [oneDigit,oneSDigit,oneTDigit]
twoDigitL = [twoDigit, twoSDigit, twoTDigit]
threeDigitL = [threeDigit, threeSDigit, threeTDigit]
for i in range (0,3):
    if i != 2:
        print (' ',oneDigitL[i],end='|')
    else:
        print (' ',oneDigitL[i])
for i in range (0,3):
    if i != 2:
        print ('',twoDigitL[i],end='|')
    else:
        print ('',twoDigitL[i])
for i in range (0,3):
    if i != 2:
        print (threeDigitL[i],end='|')
    else:
        print (threeDigitL[i])
