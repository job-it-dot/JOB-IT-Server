package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserSkill is a Querydsl query type for UserSkill
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserSkill extends EntityPathBase<UserSkill> {

    private static final long serialVersionUID = 1174730882L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserSkill userSkill = new QUserSkill("userSkill");

    public final QResume resume;

    public final QSkills skill;

    public final NumberPath<Long> userSkillId = createNumber("userSkillId", Long.class);

    public QUserSkill(String variable) {
        this(UserSkill.class, forVariable(variable), INITS);
    }

    public QUserSkill(Path<? extends UserSkill> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserSkill(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserSkill(PathMetadata metadata, PathInits inits) {
        this(UserSkill.class, metadata, inits);
    }

    public QUserSkill(Class<? extends UserSkill> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resume = inits.isInitialized("resume") ? new QResume(forProperty("resume"), inits.get("resume")) : null;
        this.skill = inits.isInitialized("skill") ? new QSkills(forProperty("skill")) : null;
    }

}

