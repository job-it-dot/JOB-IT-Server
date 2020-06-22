package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRequiredSkill is a Querydsl query type for RequiredSkill
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequiredSkill extends EntityPathBase<RequiredSkill> {

    private static final long serialVersionUID = -1528725714L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRequiredSkill requiredSkill = new QRequiredSkill("requiredSkill");

    public final QRecruit recruit;

    public final NumberPath<Long> reqSkillsId = createNumber("reqSkillsId", Long.class);

    public final QSkills skill;

    public QRequiredSkill(String variable) {
        this(RequiredSkill.class, forVariable(variable), INITS);
    }

    public QRequiredSkill(Path<? extends RequiredSkill> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRequiredSkill(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRequiredSkill(PathMetadata metadata, PathInits inits) {
        this(RequiredSkill.class, metadata, inits);
    }

    public QRequiredSkill(Class<? extends RequiredSkill> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recruit = inits.isInitialized("recruit") ? new QRecruit(forProperty("recruit"), inits.get("recruit")) : null;
        this.skill = inits.isInitialized("skill") ? new QSkills(forProperty("skill")) : null;
    }

}

