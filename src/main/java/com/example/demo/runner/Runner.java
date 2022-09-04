package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repo.CommentRepo;
import com.example.demo.repo.Postrepo;

@Component
public class Runner implements CommandLineRunner {

	
	@Autowired
	private Postrepo postRepo;

	@Autowired
	private CommentRepo cRepo;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Comment c=new Comment(); c.setCmt("fuck"); c.setUser("pooja");
		c.setFlag(true);
		Comment c1=new Comment(); c1.setCmt("fuck me"); c1.setUser("sk");
		c1.setFlag(true);
		Comment c2=new Comment(); c2.setCmt("fuck you"); c2.setUser("sri");
		c2.setFlag(false);
		Post post=new Post();
		List<Comment> of = List.of(c, c1,c2);
		post.setMsg("who will fuck me"); post.setUser("sai"); 
		((Post) post).setComment(of);
		
		Post save = postRepo.save(post);
		System.out.println("////////////////////");
		postRepo.findAll().forEach(k->{
			System.out.println(k);
		});
	
//		postRepo.delete(post);
		
		
		 
	}
}
