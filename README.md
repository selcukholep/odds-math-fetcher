# Odds Math Fetcher

q

## Requirements

* Docker

## Installation

Run below command on any terminal (cmd, powershell, etc.)

```shell
docker-compose up -d
```

> The above command can take few minutes.

All done!

The backend service runs on http://localhost:8080. 
Also, there is a **Postgresql** database which stores odds results. 

The default credentials of database given below:
- **username:** admin
- **password:** 123456
- **database:** oddsmathdb

## Usage

### Fetching Daily Odds

**Endpoint:** `GET BASE_URL/{date}`
    
**Parameters:**
- **date:** Requested date string formatted as **ISO_DATE_FORMAT** 
> **Example:** 2022-06-26
- **oddsTypes:** Requested type of odds to fetch and save. 
  It can be selected multiple types with comma seperated.
  - **Allowed Types:**
    - `FINAL_TIME_FULL`: Final Time (Full Time)
    - `FINAL_TIME_1ST_HALF`: Final Time (1st Half)
    - `FINAL_TIME_2ND_HALF`: Final Time (2nd Half)
    - `OVER_UNDER_25_FULL`: Over/ Under 2.5 (Full Time)
    - `OVER_UNDER_25_1ST_HALF`: Over/ Under 2.5 (1st Half)
    - `OVER_UNDER_25_2ND_HALF`: Over/ Under 2.5 (2nd Half)
    - `OVER_UNDER_15_FULL`: Over/ Under 1.5 (Full Time)
    - `OVER_UNDER_15_1ST_HALF`: Over/ Under 1.5 (1st Half)
    - `OVER_UNDER_15_2ND_HALF`: Over/ Under 1.5 (2nd Half)
    - `OVER_UNDER_35_FULL`: Over/ Under 3.5 (Full Time)
    - `OVER_UNDER_35_1ST_HALF`: Over/ Under 3.5 (1st Half)
    - `OVER_UNDER_35_2ND_HALF`: Over/ Under 3.5 (2nd Half)
> **Example:** FINAL_TIME_FULL,FINAL_TIME_1ST_HALF

> Attention: Requesting more types takes more time.


### Querying Odds

After fetching some match/odds, the records will be saved to database automatically.

There are some tables which stores static data and automatically extends:
- bookmakers
- country
- league
- team


Also, there are some tables which stores match/odds:
- match
- bookmaker_match (Pivot table)
- odds_final_time_full
- odds_final_time_1st_half
- ...

