package dev.example.taskList.service;

import dev.example.taskList.model.Tag;
import dev.example.taskList.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        if (tagRepository.existsById(id)) {
            tag.setId(id);
            return tagRepository.save(tag);
        }
        return null;
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

}
