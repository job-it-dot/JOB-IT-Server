package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLangClass is a Querydsl query type for LangClass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLangClass extends EntityPathBase<LangClass> {

    private static final long serialVersionUID = -1975939226L;

    public static final QLangClass langClass = new QLangClass("langClass");

    public final NumberPath<Long> langClassId = createNumber("langClassId", Long.class);

    public final StringPath langClassName = createString("langClassName");

    public QLangClass(String variable) {
        super(LangClass.class, forVariable(variable));
    }

    public QLangClass(Path<? extends LangClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLangClass(PathMetadata metadata) {
        super(LangClass.class, metadata);
    }

}

