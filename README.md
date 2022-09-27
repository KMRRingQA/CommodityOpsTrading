# CommodityOpsTrading

## application that identifies and quantifies potential profit opportunities through trading operations in commodity markets.

factors that are taken into account when selecting a potentially profitable trade:
- prices of futures(long/short)
- cost of transport(s) 
- cost of storage

i.e: is it profitable to purchase physical commodity, transport it (in time) to a different hub, where it can be hedged by second futures contract, also taking into account cost of carry?

Unique about this algorithm is its ability to recognize when multiple commodity types can be combined (mixed) to make an overall more profitable trade
e.g. attractive 4% sulfur crude oil buyer available, frequently most profitable trade may include combining two different spec (2% & 6%) crude to fill demand and highest efficency. Metering costs of mixing not taken into account (negligible).
specification mixing is just as applicable to some other industries, such as ore grades.

Given the necessary market information (list of trading hubs with associated futures markets, which in reality are often too opaque, transport costs, availability, and durations, and storage availability and durations), this algorithm is able to identify attractive trades efficiently.


below: the output of a calculation, identifying the most profitable trade with the provided market conditions (transporting commodity from London & Sydney to Hong Kong, where it can be mixed and sold for fully hedged, purely operative profit)
![image](https://user-images.githubusercontent.com/62283469/192409414-4518c785-dffc-4588-b481-b8e0f4536866.png)
