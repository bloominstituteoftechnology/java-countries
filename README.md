# Project Country Search

A student that completes this project shows that they can:

* Use IntelliJ in the following areas: application creation, code entry, and code execution
* Explain the uses of and differences between Maven, Spring, and Tomcat
* Build a REST service using Spring Boot
* Use and implement inversion of control and dependency injection with Spring
* Implement Beans throughout the Beans’ lifecycle controlling the Beans using annotations

## Introduction

The countries of the world have many different defining attributes including land size, population, and median age. Below is a list of countries to include in your data. As most people do their research using websites, we are going to create web services to help search this data. We will be returning JSON objects. Nothing fancy for now!

We will be creating an table for country data. The country model should contain the following fields. The model should be named `Country` and the table `countries`

* String name
* long population
* long landmasskm2
* int medianage

The model should also include the standard getters and setters. You should use the provided data.sql file to seed your data

Some Important Notes That Might help:

* The sort method must work with `int` - so not `long`. the solution - type casting! See the code snippet below:  
      `.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()))`
* To calculate median for stretch goals - if the list contains an odd number of items, pick the middle one. If the list contains an even number of items, pick either of the two items that lie in the middle.

Using the data.sql at the end, the endpoints will produce the following outputs. Expand to see the suggested outputs! Note that id numbers may vary.

### MVP

<details><summary>http://localhost:2019/names/all</summary>

```JSON
[
    {
        "id": 39,
        "name": "Afghanistan",
        "population": 37209007,
        "landMass": 652860,
        "medianAge": 19
    },
    {
        "id": 138,
        "name": "Albania",
        "population": 2938428,
        "landMass": 27400,
        "medianAge": 38
    },
    {
        "id": 34,
        "name": "Algeria",
        "population": 42679018,
        "landMass": 2381740,
        "medianAge": 29
    },
    {
        "id": 46,
        "name": "Angola",
        "population": 31787566,
        "landMass": 1246700,
        "medianAge": 17
    },
    {
        "id": 200,
        "name": "Antigua and Barbuda",
        "population": 104084,
        "landMass": 440,
        "medianAge": 32
    },
    {
        "id": 32,
        "name": "Argentina",
        "population": 45101781,
        "landMass": 2736690,
        "medianAge": 32
    },
    {
        "id": 139,
        "name": "Armenia",
        "population": 2936706,
        "landMass": 28470,
        "medianAge": 36
    },
    {
        "id": 198,
        "name": "Aruba",
        "population": 106053,
        "landMass": 180,
        "medianAge": 41
    },
    {
        "id": 55,
        "name": "Australia",
        "population": 25088636,
        "landMass": 7682300,
        "medianAge": 38
    },
    {
        "id": 97,
        "name": "Austria",
        "population": 8766201,
        "landMass": 82409,
        "medianAge": 44
    },
    {
        "id": 91,
        "name": "Azerbaijan",
        "population": 10014575,
        "landMass": 82658,
        "medianAge": 32
    },
    {
        "id": 177,
        "name": "Bahamas",
        "population": 403095,
        "landMass": 10010,
        "medianAge": 34
    },
    {
        "id": 152,
        "name": "Bahrain",
        "population": 1637896,
        "landMass": 760,
        "medianAge": 32
    },
    {
        "id": 8,
        "name": "Bangladesh",
        "population": 168065920,
        "landMass": 130170,
        "medianAge": 27
    },
    {
        "id": 184,
        "name": "Barbados",
        "population": 287010,
        "landMass": 430,
        "medianAge": 40
    },
    {
        "id": 95,
        "name": "Belarus",
        "population": 9433874,
        "landMass": 202910,
        "medianAge": 40
    },
    {
        "id": 81,
        "name": "Belgium",
        "population": 11562784,
        "landMass": 30280,
        "medianAge": 42
    },
    {
        "id": 178,
        "name": "Belize",
        "population": 390231,
        "landMass": 22810,
        "medianAge": 25
    },
    {
        "id": 78,
        "name": "Benin",
        "population": 11801595,
        "landMass": 112760,
        "medianAge": 19
    },
    {
        "id": 164,
        "name": "Bhutan",
        "population": 826229,
        "landMass": 38117,
        "medianAge": 29
    },
    {
        "id": 83,
        "name": "Bolivia",
        "population": 11379861,
        "landMass": 1083300,
        "medianAge": 25
    },
    {
        "id": 135,
        "name": "Bosnia & Herzegovina",
        "population": 3501774,
        "landMass": 51000,
        "medianAge": 42
    },
    {
        "id": 144,
        "name": "Botswana",
        "population": 2374636,
        "landMass": 566730,
        "medianAge": 26
    },
    {
        "id": 5,
        "name": "Brazil",
        "population": 212392717,
        "landMass": 8358140,
        "medianAge": 33
    },
    {
        "id": 175,
        "name": "Brunei",
        "population": 439336,
        "landMass": 5270,
        "medianAge": 32
    },
    {
        "id": 106,
        "name": "Bulgaria",
        "population": 6988739,
        "landMass": 108560,
        "medianAge": 45
    },
    {
        "id": 59,
        "name": "Burkina Faso",
        "population": 20321560,
        "landMass": 273600,
        "medianAge": 18
    },
    {
        "id": 80,
        "name": "Burundi",
        "population": 11575964,
        "landMass": 25680,
        "medianAge": 18
    },
    {
        "id": 172,
        "name": "Cabo Verde",
        "population": 560349,
        "landMass": 4030,
        "medianAge": 26
    },
    {
        "id": 72,
        "name": "Cambodia",
        "population": 16482646,
        "landMass": 176520,
        "medianAge": 26
    },
    {
        "id": 54,
        "name": "Cameroon",
        "population": 25312993,
        "landMass": 472710,
        "medianAge": 19
    },
    {
        "id": 38,
        "name": "Canada",
        "population": 37279811,
        "landMass": 9093510,
        "medianAge": 41
    },
    {
        "id": 126,
        "name": "Central African Republic",
        "population": 4825711,
        "landMass": 622980,
        "medianAge": 18
    },
    {
        "id": 73,
        "name": "Chad",
        "population": 15814345,
        "landMass": 1259200,
        "medianAge": 17
    },
    {
        "id": 191,
        "name": "Channel Islands",
        "population": 166828,
        "landMass": 190,
        "medianAge": 44
    },
    {
        "id": 65,
        "name": "Chile",
        "population": 18336653,
        "landMass": 743532,
        "medianAge": 35
    },
    {
        "id": 1,
        "name": "China",
        "population": 1420062022,
        "landMass": 9388211,
        "medianAge": 39
    },
    {
        "id": 29,
        "name": "Colombia",
        "population": 49849818,
        "landMass": 1109500,
        "medianAge": 32
    },
    {
        "id": 163,
        "name": "Comoros",
        "population": 850910,
        "landMass": 1861,
        "medianAge": 20
    },
    {
        "id": 117,
        "name": "Congo",
        "population": 5542197,
        "landMass": 341500,
        "medianAge": 19
    },
    {
        "id": 123,
        "name": "Costa Rica",
        "population": 4999384,
        "landMass": 51060,
        "medianAge": 34
    },
    {
        "id": 53,
        "name": "Cote d'Ivoire",
        "population": 25531083,
        "landMass": 318000,
        "medianAge": 19
    },
    {
        "id": 131,
        "name": "Croatia",
        "population": 4140148,
        "landMass": 55960,
        "medianAge": 44
    },
    {
        "id": 82,
        "name": "Cuba",
        "population": 11492046,
        "landMass": 106440,
        "medianAge": 43
    },
    {
        "id": 192,
        "name": "Curacao",
        "population": 162547,
        "landMass": 444,
        "medianAge": 42
    },
    {
        "id": 159,
        "name": "Cyprus",
        "population": 1198427,
        "landMass": 9240,
        "medianAge": 37
    },
    {
        "id": 87,
        "name": "Czech Republic",
        "population": 10630589,
        "landMass": 77240,
        "medianAge": 43
    },
    {
        "id": 115,
        "name": "Denmark",
        "population": 5775224,
        "landMass": 42430,
        "medianAge": 42
    },
    {
        "id": 160,
        "name": "Djibouti",
        "population": 985690,
        "landMass": 23180,
        "medianAge": 25
    },
    {
        "id": 86,
        "name": "Dominican Republic",
        "population": 10996774,
        "landMass": 48320,
        "medianAge": 28
    },
    {
        "id": 16,
        "name": "DR Congo",
        "population": 86727573,
        "landMass": 2267050,
        "medianAge": 17
    },
    {
        "id": 70,
        "name": "Ecuador",
        "population": 17100444,
        "landMass": 248360,
        "medianAge": 28
    },
    {
        "id": 14,
        "name": "Egypt",
        "population": 101168745,
        "landMass": 995450,
        "medianAge": 25
    },
    {
        "id": 109,
        "name": "El Salvador",
        "population": 6445405,
        "landMass": 20720,
        "medianAge": 28
    },
    {
        "id": 155,
        "name": "Equatorial Guinea",
        "population": 1360104,
        "landMass": 28050,
        "medianAge": 22
    },
    {
        "id": 120,
        "name": "Eritrea",
        "population": 5309659,
        "landMass": 101000,
        "medianAge": 19
    },
    {
        "id": 157,
        "name": "Estonia",
        "population": 1303798,
        "landMass": 42390,
        "medianAge": 43
    },
    {
        "id": 12,
        "name": "Ethiopia",
        "population": 110135635,
        "landMass": 1000000,
        "medianAge": 20
    },
    {
        "id": 161,
        "name": "Fiji",
        "population": 918757,
        "landMass": 18270,
        "medianAge": 29
    },
    {
        "id": 116,
        "name": "Finland",
        "population": 5561389,
        "landMass": 303890,
        "medianAge": 43
    },
    {
        "id": 22,
        "name": "France",
        "population": 65480710,
        "landMass": 547557,
        "medianAge": 42
    },
    {
        "id": 181,
        "name": "French Guiana",
        "population": 296847,
        "landMass": 82200,
        "medianAge": 25
    },
    {
        "id": 182,
        "name": "French Polynesia",
        "population": 288506,
        "landMass": 3660,
        "medianAge": 33
    },
    {
        "id": 147,
        "name": "Gabon",
        "population": 2109099,
        "landMass": 257670,
        "medianAge": 23
    },
    {
        "id": 146,
        "name": "Gambia",
        "population": 2228075,
        "landMass": 10120,
        "medianAge": 18
    },
    {
        "id": 133,
        "name": "Georgia",
        "population": 3904204,
        "landMass": 69490,
        "medianAge": 39
    },
    {
        "id": 19,
        "name": "Germany",
        "population": 82438639,
        "landMass": 348560,
        "medianAge": 47
    },
    {
        "id": 48,
        "name": "Ghana",
        "population": 30096970,
        "landMass": 227540,
        "medianAge": 21
    },
    {
        "id": 85,
        "name": "Greece",
        "population": 11124603,
        "landMass": 128900,
        "medianAge": 45
    },
    {
        "id": 196,
        "name": "Grenada",
        "population": 108825,
        "landMass": 340,
        "medianAge": 29
    },
    {
        "id": 174,
        "name": "Guadeloupe",
        "population": 448798,
        "landMass": 1690,
        "medianAge": 43
    },
    {
        "id": 190,
        "name": "Guam",
        "population": 167245,
        "landMass": 540,
        "medianAge": 31
    },
    {
        "id": 67,
        "name": "Guatemala",
        "population": 17577842,
        "landMass": 107160,
        "medianAge": 23
    },
    {
        "id": 75,
        "name": "Guinea",
        "population": 13398180,
        "landMass": 245720,
        "medianAge": 19
    },
    {
        "id": 150,
        "name": "Guinea-Bissau",
        "population": 1953723,
        "landMass": 28120,
        "medianAge": 19
    },
    {
        "id": 165,
        "name": "Guyana",
        "population": 786508,
        "landMass": 196850,
        "medianAge": 26
    },
    {
        "id": 84,
        "name": "Haiti",
        "population": 11242856,
        "landMass": 27560,
        "medianAge": 24
    },
    {
        "id": 94,
        "name": "Honduras",
        "population": 9568688,
        "landMass": 111890,
        "medianAge": 25
    },
    {
        "id": 104,
        "name": "Hong Kong",
        "population": 7490776,
        "landMass": 1050,
        "medianAge": 45
    },
    {
        "id": 93,
        "name": "Hungary",
        "population": 9655361,
        "landMass": 90530,
        "medianAge": 43
    },
    {
        "id": 180,
        "name": "Iceland",
        "population": 340566,
        "landMass": 100250,
        "medianAge": 37
    },
    {
        "id": 2,
        "name": "India",
        "population": 1368737513,
        "landMass": 2973190,
        "medianAge": 28
    },
    {
        "id": 4,
        "name": "Indonesia",
        "population": 269536482,
        "landMass": 1811570,
        "medianAge": 29
    },
    {
        "id": 18,
        "name": "Iran",
        "population": 82820766,
        "landMass": 1628550,
        "medianAge": 32
    },
    {
        "id": 36,
        "name": "Iraq",
        "population": 40412299,
        "landMass": 434320,
        "medianAge": 20
    },
    {
        "id": 125,
        "name": "Ireland",
        "population": 4847139,
        "landMass": 68890,
        "medianAge": 39
    },
    {
        "id": 101,
        "name": "Israel",
        "population": 8583916,
        "landMass": 21640,
        "medianAge": 31
    },
    {
        "id": 24,
        "name": "Italy",
        "population": 59216525,
        "landMass": 294140,
        "medianAge": 48
    },
    {
        "id": 140,
        "name": "Jamaica",
        "population": 2906339,
        "landMass": 10830,
        "medianAge": 31
    },
    {
        "id": 11,
        "name": "Japan",
        "population": 126854745,
        "landMass": 364555,
        "medianAge": 48
    },
    {
        "id": 89,
        "name": "Jordan",
        "population": 10069794,
        "landMass": 88780,
        "medianAge": 23
    },
    {
        "id": 63,
        "name": "Kazakhstan",
        "population": 18592970,
        "landMass": 2699700,
        "medianAge": 31
    },
    {
        "id": 27,
        "name": "Kenya",
        "population": 52214791,
        "landMass": 569140,
        "medianAge": 20
    },
    {
        "id": 193,
        "name": "Kiribati",
        "population": 120428,
        "landMass": 810,
        "medianAge": 23
    },
    {
        "id": 129,
        "name": "Kuwait",
        "population": 4248974,
        "landMass": 17820,
        "medianAge": 34
    },
    {
        "id": 111,
        "name": "Kyrgyzstan",
        "population": 6218616,
        "landMass": 191800,
        "medianAge": 26
    },
    {
        "id": 105,
        "name": "Laos",
        "population": 7064242,
        "landMass": 230800,
        "medianAge": 24
    },
    {
        "id": 151,
        "name": "Latvia",
        "population": 1911108,
        "landMass": 62200,
        "medianAge": 44
    },
    {
        "id": 112,
        "name": "Lebanon",
        "population": 6065922,
        "landMass": 10230,
        "medianAge": 31
    },
    {
        "id": 145,
        "name": "Lesotho",
        "population": 2292682,
        "landMass": 30360,
        "medianAge": 22
    },
    {
        "id": 124,
        "name": "Liberia",
        "population": 4977720,
        "landMass": 96320,
        "medianAge": 19
    },
    {
        "id": 108,
        "name": "Libya",
        "population": 6569864,
        "landMass": 1759540,
        "medianAge": 29
    },
    {
        "id": 141,
        "name": "Lithuania",
        "population": 2864459,
        "landMass": 62674,
        "medianAge": 43
    },
    {
        "id": 169,
        "name": "Luxembourg",
        "population": 596992,
        "landMass": 2590,
        "medianAge": 40
    },
    {
        "id": 166,
        "name": "Macao",
        "population": 642090,
        "landMass": 30,
        "medianAge": 39
    },
    {
        "id": 51,
        "name": "Madagascar",
        "population": 26969642,
        "landMass": 581795,
        "medianAge": 20
    },
    {
        "id": 60,
        "name": "Malawi",
        "population": 19718743,
        "landMass": 94280,
        "medianAge": 18
    },
    {
        "id": 45,
        "name": "Malaysia",
        "population": 32454455,
        "landMass": 328550,
        "medianAge": 30
    },
    {
        "id": 173,
        "name": "Maldives",
        "population": 451738,
        "landMass": 300,
        "medianAge": 31
    },
    {
        "id": 61,
        "name": "Mali",
        "population": 19689140,
        "landMass": 1220190,
        "medianAge": 16
    },
    {
        "id": 176,
        "name": "Malta",
        "population": 433245,
        "landMass": 320,
        "medianAge": 42
    },
    {
        "id": 179,
        "name": "Martinique",
        "population": 385320,
        "landMass": 1060,
        "medianAge": 46
    },
    {
        "id": 128,
        "name": "Mauritania",
        "population": 4661149,
        "landMass": 1030700,
        "medianAge": 20
    },
    {
        "id": 158,
        "name": "Mauritius",
        "population": 1271368,
        "landMass": 2030,
        "medianAge": 37
    },
    {
        "id": 186,
        "name": "Mayotte",
        "population": 266380,
        "landMass": 375,
        "medianAge": 20
    },
    {
        "id": 10,
        "name": "Mexico",
        "population": 132328035,
        "landMass": 1943950,
        "medianAge": 29
    },
    {
        "id": 197,
        "name": "Micronesia",
        "population": 106983,
        "landMass": 700,
        "medianAge": 23
    },
    {
        "id": 132,
        "name": "Moldova",
        "population": 4029750,
        "landMass": 32850,
        "medianAge": 38
    },
    {
        "id": 137,
        "name": "Mongolia",
        "population": 3166244,
        "landMass": 1553560,
        "medianAge": 29
    },
    {
        "id": 168,
        "name": "Montenegro",
        "population": 629355,
        "landMass": 13450,
        "medianAge": 39
    },
    {
        "id": 40,
        "name": "Morocco",
        "population": 36635156,
        "landMass": 446300,
        "medianAge": 30
    },
    {
        "id": 47,
        "name": "Mozambique",
        "population": 31408823,
        "landMass": 786380,
        "medianAge": 18
    },
    {
        "id": 26,
        "name": "Myanmar",
        "population": 54336138,
        "landMass": 653290,
        "medianAge": 29
    },
    {
        "id": 143,
        "name": "Namibia",
        "population": 2641996,
        "landMass": 823290,
        "medianAge": 22
    },
    {
        "id": 49,
        "name": "Nepal",
        "population": 29942018,
        "landMass": 143350,
        "medianAge": 25
    },
    {
        "id": 69,
        "name": "Netherlands",
        "population": 17132908,
        "landMass": 33720,
        "medianAge": 43
    },
    {
        "id": 185,
        "name": "New Caledonia",
        "population": 283376,
        "landMass": 18280,
        "medianAge": 33
    },
    {
        "id": 127,
        "name": "New Zealand",
        "population": 4792409,
        "landMass": 263310,
        "medianAge": 38
    },
    {
        "id": 110,
        "name": "Nicaragua",
        "population": 6351157,
        "landMass": 120340,
        "medianAge": 27
    },
    {
        "id": 57,
        "name": "Niger",
        "population": 23176691,
        "landMass": 1266700,
        "medianAge": 15
    },
    {
        "id": 7,
        "name": "Nigeria",
        "population": 200962417,
        "landMass": 910770,
        "medianAge": 18
    },
    {
        "id": 52,
        "name": "North Korea",
        "population": 25727408,
        "landMass": 120410,
        "medianAge": 35
    },
    {
        "id": 119,
        "name": "Norway",
        "population": 5400916,
        "landMass": 365268,
        "medianAge": 40
    },
    {
        "id": 122,
        "name": "Oman",
        "population": 5001875,
        "landMass": 309500,
        "medianAge": 31
    },
    {
        "id": 6,
        "name": "Pakistan",
        "population": 204596442,
        "landMass": 770880,
        "medianAge": 23
    },
    {
        "id": 130,
        "name": "Panama",
        "population": 4226197,
        "landMass": 74340,
        "medianAge": 30
    },
    {
        "id": 100,
        "name": "Papua New Guinea",
        "population": 8586525,
        "landMass": 452860,
        "medianAge": 23
    },
    {
        "id": 107,
        "name": "Paraguay",
        "population": 6981981,
        "landMass": 397300,
        "medianAge": 27
    },
    {
        "id": 42,
        "name": "Peru",
        "population": 32933835,
        "landMass": 1280000,
        "medianAge": 29
    },
    {
        "id": 13,
        "name": "Philippines",
        "population": 108106310,
        "landMass": 298170,
        "medianAge": 25
    },
    {
        "id": 37,
        "name": "Poland",
        "population": 38028278,
        "landMass": 306230,
        "medianAge": 42
    },
    {
        "id": 88,
        "name": "Portugal",
        "population": 10254666,
        "landMass": 91590,
        "medianAge": 46
    },
    {
        "id": 134,
        "name": "Puerto Rico",
        "population": 3654978,
        "landMass": 8870,
        "medianAge": 38
    },
    {
        "id": 142,
        "name": "Qatar",
        "population": 2743901,
        "landMass": 11610,
        "medianAge": 32
    },
    {
        "id": 162,
        "name": "Reunion",
        "population": 889918,
        "landMass": 2500,
        "medianAge": 36
    },
    {
        "id": 62,
        "name": "Romania",
        "population": 19483360,
        "landMass": 230170,
        "medianAge": 43
    },
    {
        "id": 9,
        "name": "Russia",
        "population": 143895551,
        "landMass": 16376870,
        "medianAge": 40
    },
    {
        "id": 77,
        "name": "Rwanda",
        "population": 12794412,
        "landMass": 24670,
        "medianAge": 20
    },
    {
        "id": 189,
        "name": "Saint Lucia",
        "population": 180454,
        "landMass": 610,
        "medianAge": 35
    },
    {
        "id": 188,
        "name": "Samoa",
        "population": 198909,
        "landMass": 2830,
        "medianAge": 22
    },
    {
        "id": 187,
        "name": "Sao Tome & Principe",
        "population": 213379,
        "landMass": 960,
        "medianAge": 19
    },
    {
        "id": 41,
        "name": "Saudi Arabia",
        "population": 34140662,
        "landMass": 2149690,
        "medianAge": 32
    },
    {
        "id": 71,
        "name": "Senegal",
        "population": 16743859,
        "landMass": 192530,
        "medianAge": 19
    },
    {
        "id": 98,
        "name": "Serbia",
        "population": 8733407,
        "landMass": 87460,
        "medianAge": 41
    },
    {
        "id": 201,
        "name": "Seychelles",
        "population": 95702,
        "landMass": 460,
        "medianAge": 36
    },
    {
        "id": 103,
        "name": "Sierra Leone",
        "population": 7883123,
        "landMass": 72180,
        "medianAge": 19
    },
    {
        "id": 114,
        "name": "Singapore",
        "population": 5868104,
        "landMass": 700,
        "medianAge": 42
    },
    {
        "id": 118,
        "name": "Slovakia",
        "population": 5450987,
        "landMass": 48088,
        "medianAge": 41
    },
    {
        "id": 149,
        "name": "Slovenia",
        "population": 2081900,
        "landMass": 20140,
        "medianAge": 45
    },
    {
        "id": 167,
        "name": "Solomon Islands",
        "population": 635254,
        "landMass": 27990,
        "medianAge": 21
    },
    {
        "id": 74,
        "name": "Somalia",
        "population": 15636171,
        "landMass": 627340,
        "medianAge": 17
    },
    {
        "id": 25,
        "name": "South Africa",
        "population": 58065097,
        "landMass": 1213090,
        "medianAge": 27
    },
    {
        "id": 28,
        "name": "South Korea",
        "population": 51339238,
        "landMass": 97230,
        "medianAge": 43
    },
    {
        "id": 76,
        "name": "South Sudan",
        "population": 13263184,
        "landMass": 610952,
        "medianAge": 19
    },
    {
        "id": 30,
        "name": "Spain",
        "population": 46441049,
        "landMass": 498800,
        "medianAge": 46
    },
    {
        "id": 58,
        "name": "Sri Lanka",
        "population": 21018859,
        "landMass": 62710,
        "medianAge": 34
    },
    {
        "id": 194,
        "name": "St. Vincent & Grenadines",
        "population": 110488,
        "landMass": 390,
        "medianAge": 32
    },
    {
        "id": 121,
        "name": "State of Palestine",
        "population": 5186790,
        "landMass": 6020,
        "medianAge": 20
    },
    {
        "id": 35,
        "name": "Sudan",
        "population": 42514094,
        "landMass": 1765048,
        "medianAge": 20
    },
    {
        "id": 171,
        "name": "Suriname",
        "population": 573085,
        "landMass": 156000,
        "medianAge": 30
    },
    {
        "id": 153,
        "name": "Swaziland",
        "population": 1415414,
        "landMass": 17200,
        "medianAge": 21
    },
    {
        "id": 90,
        "name": "Sweden",
        "population": 10053135,
        "landMass": 410340,
        "medianAge": 41
    },
    {
        "id": 99,
        "name": "Switzerland",
        "population": 8608259,
        "landMass": 39516,
        "medianAge": 43
    },
    {
        "id": 64,
        "name": "Syria",
        "population": 18499181,
        "landMass": 183630,
        "medianAge": 22
    },
    {
        "id": 56,
        "name": "Taiwan",
        "population": 23758247,
        "landMass": 35410,
        "medianAge": 42
    },
    {
        "id": 96,
        "name": "Tajikistan",
        "population": 9292000,
        "landMass": 139960,
        "medianAge": 23
    },
    {
        "id": 23,
        "name": "Tanzania",
        "population": 60913557,
        "landMass": 885800,
        "medianAge": 18
    },
    {
        "id": 148,
        "name": "TFYR Macedonia",
        "population": 2086720,
        "landMass": 25220,
        "medianAge": 39
    },
    {
        "id": 20,
        "name": "Thailand",
        "population": 69306160,
        "landMass": 510890,
        "medianAge": 40
    },
    {
        "id": 156,
        "name": "Timor-Leste",
        "population": 1352360,
        "landMass": 14870,
        "medianAge": 18
    },
    {
        "id": 102,
        "name": "Togo",
        "population": 8186384,
        "landMass": 54390,
        "medianAge": 19
    },
    {
        "id": 195,
        "name": "Tonga",
        "population": 110041,
        "landMass": 720,
        "medianAge": 22
    },
    {
        "id": 154,
        "name": "Trinidad and Tobago",
        "population": 1375443,
        "landMass": 5130,
        "medianAge": 36
    },
    {
        "id": 79,
        "name": "Tunisia",
        "population": 11783168,
        "landMass": 155360,
        "medianAge": 33
    },
    {
        "id": 17,
        "name": "Turkey",
        "population": 82961805,
        "landMass": 769630,
        "medianAge": 32
    },
    {
        "id": 113,
        "name": "Turkmenistan",
        "population": 5942561,
        "landMass": 469930,
        "medianAge": 27
    },
    {
        "id": 21,
        "name": "U.K.",
        "population": 66959016,
        "landMass": 241930,
        "medianAge": 41
    },
    {
        "id": 3,
        "name": "U.S.",
        "population": 329093110,
        "landMass": 9147420,
        "medianAge": 38
    },
    {
        "id": 199,
        "name": "U.S. Virgin Islands",
        "population": 104909,
        "landMass": 350,
        "medianAge": 42
    },
    {
        "id": 31,
        "name": "Uganda",
        "population": 45711874,
        "landMass": 199810,
        "medianAge": 16
    },
    {
        "id": 33,
        "name": "Ukraine",
        "population": 43795220,
        "landMass": 579320,
        "medianAge": 41
    },
    {
        "id": 92,
        "name": "United Arab Emirates",
        "population": 9682088,
        "landMass": 83600,
        "medianAge": 34
    },
    {
        "id": 136,
        "name": "Uruguay",
        "population": 3482156,
        "landMass": 175020,
        "medianAge": 36
    },
    {
        "id": 43,
        "name": "Uzbekistan",
        "population": 32807368,
        "landMass": 425400,
        "medianAge": 28
    },
    {
        "id": 183,
        "name": "Vanuatu",
        "population": 288017,
        "landMass": 12190,
        "medianAge": 23
    },
    {
        "id": 44,
        "name": "Venezuela",
        "population": 32779868,
        "landMass": 882050,
        "medianAge": 29
    },
    {
        "id": 15,
        "name": "Viet Nam",
        "population": 97429061,
        "landMass": 310070,
        "medianAge": 33
    },
    {
        "id": 170,
        "name": "Western Sahara",
        "population": 582478,
        "landMass": 266000,
        "medianAge": 28
    },
    {
        "id": 50,
        "name": "Yemen",
        "population": 29579986,
        "landMass": 527970,
        "medianAge": 20
    },
    {
        "id": 66,
        "name": "Zambia",
        "population": 18137369,
        "landMass": 743390,
        "medianAge": 18
    },
    {
        "id": 68,
        "name": "Zimbabwe",
        "population": 17297495,
        "landMass": 386850,
        "medianAge": 20
    }
]
```

</details>

<details><summary>http://localhost:2019/names/start/u</summary>

```JSON
[
    {
        "id": 21,
        "name": "U.K.",
        "population": 66959016,
        "landMass": 241930,
        "medianAge": 41
    },
    {
        "id": 3,
        "name": "U.S.",
        "population": 329093110,
        "landMass": 9147420,
        "medianAge": 38
    },
    {
        "id": 199,
        "name": "U.S. Virgin Islands",
        "population": 104909,
        "landMass": 350,
        "medianAge": 42
    },
    {
        "id": 31,
        "name": "Uganda",
        "population": 45711874,
        "landMass": 199810,
        "medianAge": 16
    },
    {
        "id": 33,
        "name": "Ukraine",
        "population": 43795220,
        "landMass": 579320,
        "medianAge": 41
    },
    {
        "id": 92,
        "name": "United Arab Emirates",
        "population": 9682088,
        "landMass": 83600,
        "medianAge": 34
    },
    {
        "id": 136,
        "name": "Uruguay",
        "population": 3482156,
        "landMass": 175020,
        "medianAge": 36
    },
    {
        "id": 43,
        "name": "Uzbekistan",
        "population": 32807368,
        "landMass": 425400,
        "medianAge": 28
    }
]
```

</details>

<details><summary>http://localhost:2019/population/total</summary>

In the console:

```TEXT

The Total Population is 7713495811

```

</details>

<details><summary>http://localhost:2019/population/min</summary>

```JSON
{
    "id": 201,
    "name": "Seychelles",
    "population": 95702,
    "landMass": 460,
    "medianAge": 36
}
```

</details>

<details><summary>http://localhost:2019/population/max</summary>

```JSON
{
    "id": 1,
    "name": "China",
    "population": 1420062022,
    "landMass": 9388211,
    "medianAge": 39
}
```

</details>

### Stretch Goal

<details><summary>http://localhost:2019/population/median</summary>

```JSON
{
    "id": 100,
    "name": "Papua New Guinea",
    "population": 8586525,
    "landMass": 452860,
    "medianAge": 23
}
```

</details>


</details>

## Instruction

The following URLs should return the requested data given the parameters

* [ ] /names/all - return the names of all the countries alphabetically
* [ ] /names/start/{letter} - return the countries alphabetically that begin with the given letter

* [ ] /population/total - return the total population of the all countries in the console while returning Http Status OK as the response.
* [ ] /population/min - return the country with the smallest population
* [ ] /population/max - return the country with the largest population

### Stretch Goal

* [ ] /population/median - return the country with the median population
