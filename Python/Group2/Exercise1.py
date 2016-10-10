taxNumber = input("Please, enter Tax Identification Number:")
if len(taxNumber) != 9:
    print ("Tax Identification Number not valid. Try again.")
taxList = [taxNumber[7], taxNumber[6],taxNumber[5], taxNumber[4], taxNumber[3], taxNumber[2], taxNumber[1], taxNumber[0]]
n = 1
taxNewList =[]
for x in range (0,7):
    taxNewNumber = int(taxList[x])*(2**n)
    n += 1
    taxNewList.append (taxNewNumber)
numberSum = sum(taxNewList)
elevenRemainder = numberSum % 11
tenRemainder = elevenRemainder % 10
if (int(tenRemainder) == int(taxNumber[8])):
    print ("Tax Identification Number Valid.")
else :
    print ("Tax Identification Number not valid.")
