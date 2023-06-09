package com.galmv_.niceia.reaction.reactionService;

import com.galmv_.niceia.UnitTestFactory;
import com.galmv_.niceia.reaction.Enums.ComponentType;
import com.galmv_.niceia.reaction.Enums.Type;
import com.galmv_.niceia.reaction.Reaction;
import com.galmv_.niceia.reaction.exceptions.ReactionNotFoundedException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.UUID;

public class UnitTestDeleteReactionService extends UnitTestFactory {

    @Test
    @DisplayName("should to be able to delete a reaction")
    public void testSuccessDelete(){
        Reaction reaction1 = reactionRepository.save(new Reaction(null, Type.LIKE, ComponentType.COMMENT, comment.getId(), student));

        this.reactionService.delete(reaction1.getId());

        Assert.assertTrue(reactionRepository.findById(reaction1.getId()).isEmpty());
    }

    @Test
    @DisplayName("should not to be able to delete a reaction if this one don't exists")
    public void testFailDelete(){

        Assert.assertThrows(ReactionNotFoundedException.class, () ->
                this.reactionService.delete(new UUID(0, 0)));
    }
}
