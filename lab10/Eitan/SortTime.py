# Program to determine the calculated time for the report

import sys

c = float(sys.argv[1]) / (20000**2)

print "500000 time: ", c * 500000**2
print "5000000 time: ", c * 5000000**2
