package com.yjg.service.mapper;

import java.util.List;

import com.yjg.api.model.Message;

public interface MessageMapper {
	public void inserMessage(Message message);
	public void updateMessage(Message message);
	public Message findOneMessage(Message message);
	public List<Message> findAllMessage(Message message);
}
