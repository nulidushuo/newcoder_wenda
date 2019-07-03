package com.nowcoder.mywenda.service;

import com.nowcoder.mywenda.dao.QuestionDAO;
import com.nowcoder.mywenda.model.Question;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionService {
    @Resource
    QuestionDAO questionDAO;

    public List<Question> getLatestQuestions(int userId, int offset, int limit){
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }
}
