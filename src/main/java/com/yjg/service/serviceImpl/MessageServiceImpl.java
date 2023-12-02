package com.yjg.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjg.api.model.Message;
import com.yjg.api.service.MessageService;
import com.yjg.service.mapper.MessageMapper;
import com.yjg.util.MyException;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Resource
	private MessageMapper messageMapper;

	@Override
	public Map<String, Object> addMessage(Map<String, Object> map)throws MyException {
		Message message=(Message)map.get("Message");
		messageMapper.inserMessage(message);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetCode", "1");
		map1.put("RetMessage","�ɹ�");
		return map1;
	}

	@Override
	public Map<String, Object> selectOneMessage(Map<String, Object> map)throws MyException {
		if(map.get("Message")==null){
			throw new MyException("message����Ϊ�գ�");
		}
		Message message=(Message)map.get("Message");
		if(message.getMessageId()==null){
			throw new MyException("messageID����Ϊ�գ�");
		}
		Message message2 = messageMapper.findOneMessage(message);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetData", message2);
		map1.put("RetCode", "1");
		map1.put("RetMessage","�ɹ�");
		return map1;
	}

	@Override
	public Map<String, Object> selectAllMessage(Map<String, Object> map) throws MyException{
		if(map.get("Message")==null){
			throw new MyException("message����Ϊ�գ�");
		}
		Message message=(Message)map.get("Message");
		List<Message> list = messageMapper.findAllMessage(message);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetData", list);
		map1.put("RetCode", "1");
		map1.put("RetMessage","�ɹ�");
		return map1;
	}

	@Override
	public Map<String, Object> updateMessage(Map<String, Object> map) throws MyException{
		if(map.get("Message")==null){
			throw new MyException("message����Ϊ�գ�");
		}
		Message message=(Message)map.get("Message");
		if(message.getMessageId()==null){
			throw new MyException("messageID����Ϊ�գ�");
		}
		messageMapper.updateMessage(message);
		Map<String,Object> map1=new HashMap<>();
		map1.put("RetCode", "1");
		map1.put("RetMessage","�ɹ�");
		return map1;
	}
	

}
