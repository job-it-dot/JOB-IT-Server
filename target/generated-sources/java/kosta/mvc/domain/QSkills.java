package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSkills is a Querydsl query type for Skills
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSkills extends EntityPathBase<Skills> {

    private static final long serialVersionUID = -635550074L;

    public static final QSkills skills = new QSkills("skills");

    public final NumberPath<Long> skillId = createNumber("skillId", Long.class);

    public final StringPath skillName = createString("skillName");

    public QSkills(String variable) {
        super(Skills.class, forVariable(variable));
    }

    public QSkills(Path<? extends Skills> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSkills(PathMetadata metadata) {
        super(Skills.class, metadata);
    }

}

