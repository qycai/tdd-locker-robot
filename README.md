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

## primaryLockerRobot存取包

given：primaryLockerRobot管理M型的locker1和locker2，locker1和locker2都有剩余空间，普通用户有一个M型包  
when：存包  
then：返回票据，包存入locker1  

given：primaryLockerRobot管理M型的locker1和locker2，locker1没有剩余空间，locker2有剩余空间，普通用户有一个M型包  
when：存包  
then：返回票据，包存入locker2  

given：primaryLockerRobot管理M型的locker1和locker2，locker1、locker2都没有剩余空间，普通用户有一个M型包  
when：存包  
then：存包失败，提示已满  

given：primaryLockerRobot管理M型的locker1和locker2，用户已经存入一个M型的包，使用有效票据  
when：取包  
then：取包成功  

given：primaryLockerRobot管理M型的locker1和locker2，用户使用无效票据  
when：取包  
then：取包失败，提示票无效  
