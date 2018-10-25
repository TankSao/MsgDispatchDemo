# MsgDispatchDemo
从项目中抽出来的消息分发demo</br>
Activity+Service+BroadCast</br>
一共四个JAVA类，其中：</br>
ManiActivity为主界面，主要负责开启服务与注册广播以及UI更新</br>
MsgService为服务，可接收Activity传来的参数（项目中建立长连接需要用到）以及发送广播（通知Activity更新UI）</br>
MsgBroadcast，接收广播传递的数据</br>
MsgListener，广播接收到新消息的监听
