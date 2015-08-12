package tr.lkd.lyk2015.springtodo.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.lkd.lyk2015.springtodo.dal.TodoDao;
import tr.lkd.lyk2015.springtodo.model.Todo;

@Transactional
@Service
public class TodoService implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected TodoDao todoDao;

	public Long create(final Todo todo) {

		if (todo == null) {
			throw new RuntimeException("Model cannot be null");
		}
		String date = String.valueOf(todo.getDueDate());

		return todoDao.create(todo);
	}

	public Todo getById(final Long id) {

		if (id == null) {
			throw new RuntimeException("Id cannot be null");
		}

		return todoDao.getById(id);
	}

	public Todo update(final Todo todo) {

		if (todo == null) {
			throw new RuntimeException("Model cannot be null");
		}

		return todoDao.update(todo);
	}

	public List<Todo> getAll() {

		return todoDao.getAll();
	}
	
	public void markAsDone(Long id, Boolean done){
		Todo todo = getById(id);
		todo.setDone(done);
	}

}