#!/usr/bin/python

from datetime import date
from sys import argv

future_year = 2015
future_month = 2
future_day = 14

if len(argv) == 4:
    future_year = argv[1]
    future_month = argv[2]
    future_day = argv[3]

today = date.today()
future = date(int(future_year), int(future_month), int(future_day))

diff = future - today
print("{0} day{1} from {2} to {3}".format(diff.days, "s" if diff.days > 1 else '', today.strftime('%Y %m %d'), future.strftime('%Y %m %d')))
