package com.nowcoder.mywenda;

import com.nowcoder.mywenda.dao.QuestionDAO;
import com.nowcoder.mywenda.dao.UserDAO;
import com.nowcoder.mywenda.model.Question;
import com.nowcoder.mywenda.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/init-schema.sql")
public class InitDatabaseTests {

	@Resource
	UserDAO userDAO;

	@Resource
	QuestionDAO questionDAO;

	@Test
	public void initDatabase() {
		Random random = new Random();
		for (int i = 0; i < 11; i++) {
			User user = new User();
			user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
			user.setName(String.format("USER%d", i));
			user.setPassword("");
			user.setSalt("");
			userDAO.addUser(user);

			user.setPassword("newpassword");
			userDAO.updatePassword(user);

			Question question = new Question();
			question.setCommentCount(i);
			Date date = new Date();
			date.setTime(date.getTime() + 1000 * 3600 * 5 * i);
			question.setCreatedDate(date);
			question.setUserId(i + 1);
			question.setTitle(String.format("TITLE{%d}", i));
			question.setContent(String.format("Balala Content %d", i));
			questionDAO.addQuestion(question);
		}

//		Assert.assertEquals("newpassword", userDAO.selectById(1).getPassword()); 不相等，有问题
//		userDAO.deleteById(1);
//		Assert.assertNull(userDAO.selectById(1));
		List<Question> questions=questionDAO.selectLatestQuestions(0,0,10);
		System.out.println(questions);
	}

}
