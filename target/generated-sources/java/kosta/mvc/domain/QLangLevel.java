package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLangLevel is a Querydsl query type for LangLevel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLangLevel extends EntityPathBase<LangLevel> {

    private static final long serialVersionUID = -1967816334L;

    public static final QLangLevel langLevel = new QLangLevel("langLevel");

    public final NumberPath<Long> langLevelId = createNumber("langLevelId", Long.class);

    public final StringPath langLevelName = createString("langLevelName");

    public QLangLevel(String variable) {
        super(LangLevel.class, forVariable(variable));
    }

    public QLangLevel(Path<? extends LangLevel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLangLevel(PathMetadata metadata) {
        super(LangLevel.class, metadata);
    }

}

