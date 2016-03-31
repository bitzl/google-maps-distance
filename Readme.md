# Travel Distance Matrix
[![Build Status](https://travis-ci.org/bitzl/google-maps-distance.svg?branch=master)](https://travis-ci.org/bitzl/google-maps-distance)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/80886f5c2ab14794b78b9e85114cb7e5)](https://www.codacy.com/app/marcus_2/maps-distance-matrix)
[![Apache License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)

This software creates a list of travel information from random locations to a certain destination using the Google Maps Distance API. Requirements are specified in a YAML file:

    apiKey: API_KEY
    samples: 10
    file: marienplatz.csv
    destination:
      latitude: 48.137493
      longitude: 11.575363
    range:
      latitude: [47.637493, 48.637493]
      longitude: [11.075363, 12.075363]

To query new data, run

    java -jar distance-matrix.jar job.yml

If the out file specified in job.yml exists, new data will be appended.

*Please note that a larger sample size only reduces the number of requested API-calls to get the same number of samples. It does not help to get more data for the same quota (that is, 10 calls with sample size 1 count the same as 1 call with sample size 10).*