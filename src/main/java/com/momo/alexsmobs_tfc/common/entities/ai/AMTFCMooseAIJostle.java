package com.momo.alexsmobs_tfc.common.entities.ai;

import com.github.alexthe666.alexsmobs.entity.ai.MooseAIJostle;
import com.momo.alexsmobs_tfc.common.entities.wild.AMTFCEntityMoose;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class AMTFCMooseAIJostle extends MooseAIJostle {

    private static final TargetingConditions JOSTLE_PREDICATE = TargetingConditions.forNonCombat().range(16D).ignoreLineOfSight();
    protected AMTFCEntityMoose targetMoose;
    private final AMTFCEntityMoose moose;
    private final Level world;

    public AMTFCMooseAIJostle(AMTFCEntityMoose moose) {
        super(moose);
        this.moose = moose;
        this.world = moose.level();
    }

    @Override
    public boolean canUse() {
        if (this.moose.isJostling() || !moose.isAntlered() || this.moose.isBaby() || this.moose.getTarget() != null || this.moose.jostleCooldown > 0) {
            return false;
        }
        if(this.moose.instantlyTriggerJostleAI || this.moose.getRandom().nextInt(30) == 0){
            this.moose.instantlyTriggerJostleAI = false;
            if (this.moose.getJostlingPartner() instanceof AMTFCEntityMoose) {
                targetMoose = (AMTFCEntityMoose) moose.getJostlingPartner();
                return targetMoose.jostleCooldown == 0;
            } else {
                AMTFCEntityMoose possiblePartner = this.getNearbyMoose();
                if (possiblePartner != null) {
                    this.moose.setJostlingPartner(possiblePartner);
                    possiblePartner.setJostlingPartner(moose);
                    targetMoose = possiblePartner;
                    targetMoose.instantlyTriggerJostleAI = true;
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    private AMTFCEntityMoose getNearbyMoose() {
        List<AMTFCEntityMoose> listOfMeese = this.world.getNearbyEntities(AMTFCEntityMoose.class, JOSTLE_PREDICATE, this.moose, this.moose.getBoundingBox().inflate(16.0D));
        double lvt_2_1_ = 1.7976931348623157E308D;
        AMTFCEntityMoose lvt_4_1_ = null;

        for (AMTFCEntityMoose lvt_6_1_ : listOfMeese) {
            if (this.moose.canJostleWith(lvt_6_1_) && this.moose.distanceToSqr(lvt_6_1_) < lvt_2_1_) {
                lvt_4_1_ = lvt_6_1_;
                lvt_2_1_ = this.moose.distanceToSqr(lvt_6_1_);
            }
        }

        return lvt_4_1_;
    }

}
