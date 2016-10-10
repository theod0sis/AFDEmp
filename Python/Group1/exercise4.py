import math
valueA = float(input("Please, enter the a value of your quadratic equation:"))
valueB = float(input("Please, enter the b value of your quadratic equation:"))
valueC = float(input("Please, enter the c value of your quadratic equation:"))
D = valueB**2 - (4*valueA*valueC)
if D < 0:
    print("No real solutions exist for the given values.")
else :
    xOne = ((-valueB) + math.sqrt(D))/(2*valueA)
    xTwo = ((-valueB) - math.sqrt(D))/(2*valueA)
    print ("The solutions of your quadratic equation are:",xOne,xTwo)
