package com.apress.demo.springblog.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.domain.PostStatus;

public class PostMapper implements RowMapper<Post>{

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException{
        Post post = new Post();

        post.setId(rs.getInt("id"));
        post.setTitle(rs.getString("title"));
        post.setDescription(rs.getString("description"));
        post.setBody(rs.getString("body"));
        post.setPostStatus((PostStatus) rs.getObject("post_status"));
        post.setCreatedOn(convertToLocalDateTime(rs.getDate("created_on")));
        post.setUpdatedOn(convertToLocalDateTime(rs.getDate("updated_on")));

        return post;
    }

    private LocalDate convertToLocalDateTime(Date date) {
        if(date == null){
            return null;
        }

        return date.toLocalDate();
    }
}
