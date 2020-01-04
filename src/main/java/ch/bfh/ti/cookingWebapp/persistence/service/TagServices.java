package ch.bfh.ti.cookingWebapp.persistence.service;

import ch.bfh.ti.cookingWebapp.persistence.model.Recipe;
import ch.bfh.ti.cookingWebapp.persistence.model.Tag;
import ch.bfh.ti.cookingWebapp.persistence.model.TagType;
import ch.bfh.ti.cookingWebapp.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServices {
    private TagRepository tagRepository;

    @Autowired
    public TagServices(TagRepository tagRepository) {
        super();
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        List<Tag> tags = new ArrayList<>();
        this.tagRepository.findAll().forEach(tags::add);
        return tags;
    }

    public Tag getTagById(Long tagId){
        Optional<Tag> tag = tagRepository.findById(tagId);
        return tag.orElse(null);
    }

    public void addTag(String tagName) {
        Tag tag = new Tag(tagName);
        this.tagRepository.save(tag);
    }

    public List<Tag> getTagsByType(TagType type) {
        List<Tag> allTags = getAllTags();
        List<Tag> tags = new ArrayList<>();
        for (Tag t:allTags){
            if (t.getType() == (type.tagNumber())) {
                tags.add(t);
            }
        }
        return tags;
    }
}
