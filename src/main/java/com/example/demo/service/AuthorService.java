package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

 public Optional<Author> getAuthor(Long id) {
        return authorRepository.findById(id);
    }
    
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id).orElseThrow();
        author.setName(authorDetails.getName());
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
