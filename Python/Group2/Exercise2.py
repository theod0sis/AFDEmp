binNumber = input("Please, enter an 8-bit binary number")
if len(binNumber) !=8:
    print ("Binary Number not valid. Try again.")
binList = []
for i in range (0,6):
    binList.append (int(binNumber[i]))
numberSum = sum(binList)
if (numberSum % 2)==0 and int(binNumber[7]) == 0:
    print ("Parity check OK.")
elif (numberSum % 2)!=0 and int(binNumber[7])==1:
    print ("Parity check OK.")
else :
    print ("Parity check not OK.")
