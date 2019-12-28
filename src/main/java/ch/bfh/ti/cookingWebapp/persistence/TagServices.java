package ch.bfh.ti.cookingWebapp.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServices {
    private TagRepository tagRepository;

    @Autowired
    public TagServices(TagRepository tagRepository) {
        super();
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllRecipes(){
        List<Tag> tags = new ArrayList<>();
        this.tagRepository.findAll().forEach(tags::add);
        return tags;
    }

    public void addTag(String tagName){
        Tag tag = new Tag(tagName);
        this.tagRepository.save(tag);
    }
}
