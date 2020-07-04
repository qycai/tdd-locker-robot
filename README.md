# Tasks

## locker存取包

given：用户有一个S型包，S型储物柜locker1还有剩余空间  
when：存包  
then：返回票据，包存入locker1  

given：用户有一个S型包，S型储物柜locker1没有剩余空间  
when：存包  
Then：存包失败，提示已满    

given：用户已经存了一个S型的包，使用有效票据  
when：取包  
then：取包成功  

given：用户使用伪造票据  
when：取包  
then：取包失败，提示票据无效  
