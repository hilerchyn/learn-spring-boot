package com.apress.demo.springblog.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository = new PostRepository();

  public void addPost(Post post) {
    postRepository.addPost(post);
  }

  public Set<Post> findAllPosts() {
    return postRepository.findAllPosts();
  }

  public boolean postExistsWithTitle(String title) {
    // FIXME: 校验逻辑失效，因为findAllPosts()方法取得数据为空
    return postRepository.findAllPosts().stream()
      .anyMatch(post -> post.getTitle().equals(title));
  }
}
