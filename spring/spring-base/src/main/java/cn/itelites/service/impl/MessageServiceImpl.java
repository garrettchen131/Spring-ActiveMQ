package cn.itelites.service.impl;

import cn.itelites.service.IMessageService;

public class MessageServiceImpl implements IMessageService
{
    @Override
    public String echo(String msg)
    {
        return "【ECHO】" + msg;
    }
}
