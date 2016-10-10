givenYear = input("Please enter the year you want to know the date of the Orthodox Easter")
y = int(givenYear)
if y < 1900 or y > 2099:
    print ("Please enter a year between 1900 and 2099")
a = y%4
b = y%7
c = y%19
d = (19*c+15)%30
e = (2*a+4*b-d+34)%7
day = ((d+e+114)%31)+1
month =((d+e+114)//31)                
day =day + 13
if month == 3 or month == 5 and day < 31:
    print ("Day:",day,' ',"Month:",month)
elif month == 4 and day < 30:
    print ("Day:",day,' ',"Month:",month)
else:
    if month == 3 or month == 5:
        day = day - 31
        month += 1
        print ("Day:",day,' ',"Month:",month)
    else:
        day = day - 30
        month += 1
        print ("Day:",day,' ',"Month:",month)
