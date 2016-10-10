upperLimit = input("Please input an upper limit")
k = int(upperLimit)
politeNumbers = []
powerOfTwo = []
i=0
for x in range (0,k+1):
    i = 2**x
    if i>k:
        break
    powerOfTwo.append (i)
for y in range (1,k+1):
    if y not in powerOfTwo:
        politeNumbers.append (y)
for z in range (0,len(politeNumbers)):
    if z==0:
        print (politeNumbers[z],end=' ')
    elif z % 10 == 0:
        print (politeNumbers[z])
    else:
        print (politeNumbers[z],end=' ')
