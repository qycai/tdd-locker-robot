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

given：小樱使用已用过的票  
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

given：primaryLockerRobot管理M型的locker1和locker2，小樱使用已用过的票  
when：取包  
then：取包失败，提示票无效  

given：存在一个S型locker1和primaryLockerRobot  
when：使用primaryLockerRobot管理locker1  
then：配置失败，提示locker型号和robot不匹配  

## superLockerRobot存取包
given：superLockerRobot管理L型的locker1和locker2，locker1剩余空间大于locker2的剩余空间，普通用户有一个L型包  
when：存包  
then：返回票据，包存入locker1  

given：superLockerRobot管理L型的locker1和locker2，locker1剩余空间小于locker2的剩余空间，普通用户有一个L型包  
when：存包  
then：返回票据，包存入locker2  

given：superLockerRobot管理L型的locker1和locker2，locker1剩余空间等于locker2的剩余空间，普通用户有一个L型包  
when：存包  
then：返回票据，包存入locker1  

given：superLockerRobot管理L型的locker1和locker2，locker1、locker2都没有剩余空间，普通用户有一个L型包  
when：存包  
then：存包失败，提示储物柜已满  

given：superLockerRobot管理L型的locker1和locker2，用户使用有效票据  
when：取包  
then：取包成功  

given：superLockerRobot管理L型的locker1和locker2，用户使无效票据  
when：取包  
then：取包失败，提示票据无效  

given：primaryLockerRobot管理M型的locker1，superLockerRobot管理L型的locker2，用户的M型的包存入locker1  
when：小樱找superLockerRobot取包  
then：取包失败，提示票据无效  

given：primaryLockerRobot管理M型的locker1，superLockerRobot管理L型的locker2，还有一个S型locker3，用户的M型的包存入locker1  
when：小樱找locker3取包  
then：取包失败，提示票据无效  

given：superLockerRobot管理L型的locker1和locker2，小樱使用已用过的票  
when：取包  
then：取包失败，提示票据无效  

given：存在一个S型locker1和superLockerRobot  
when：使用superLockerRobot管理locker1  
then：配置失败，提示locker型号和robot不匹配  

given：存在一个M型locker1和superLockerRobot  
when：使用superLockerRobot管理locker1  
then：配置失败，提示locker型号和robot不匹配  

## lockerRobotManager存取包

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot管理locker3，locker1、2、3都有剩余空间  
when：用户存S型包  
then：返回票据，包存入locker1  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot管理locker3，locker1、2、3都有剩余空间  
when：用户存M型包  
then：返回票据，包存入locker2  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot管理locker3，locker1、2、3都有剩余空间  
when：用户存L型包  
then：返回票据，包存入locker3  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot管理locker3，locker1没有剩余空间，locker2、3有剩余空间  
when：用户存S型包  
then：存包失败，提示已满  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot管理locker3，locker2没有剩余空间，locker1、3有剩余空间  
when：用户存M型包  
then：存包失败，提示已满  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot管理locker3，locker3没有剩余空间，locker1、2有剩余空间  
when：用户存L型包  
then：存包失败，提示已满  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot使用有效票  
when：取包S型包  
then：取包成功  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot使用有效票  
when：取包M型包  
then：取包成功  

given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot使用有效票  
when：取包L型包  
then：取包成功  
 
given：manager管理一个S型locker1和一个primaryLockerRobot和一个superLockerRobot，primaryLockerRobot管理locker2，superLockerRobot使用无效票  
when：取包  
then：取包失败，提示票无效  
