tenNumber = input("Please, enter a 10 digit number")
if len(tenNumber) != 10:
    print ("Please, try again")
tenListEven = []
tenListOdd = []
for i in range (0,9):
    if int(tenNumber[i])%2 == 0:
        tenListEven.append (tenNumber[i])
    else :
        tenListOdd.append (tenNumber[i])
print (tenListEven)
for k in range (0,5):
    print (tenListOdd[k],end=' ')
print()
print(end=" ")
for l in range (0,3):
    print (tenListEven[l],end=' ')
