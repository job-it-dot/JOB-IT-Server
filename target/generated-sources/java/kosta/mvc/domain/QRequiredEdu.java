package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRequiredEdu is a Querydsl query type for RequiredEdu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequiredEdu extends EntityPathBase<RequiredEdu> {

    private static final long serialVersionUID = -2142384173L;

    public static final QRequiredEdu requiredEdu = new QRequiredEdu("requiredEdu");

    public final NumberPath<Integer> reqEduGrade = createNumber("reqEduGrade", Integer.class);

    public final StringPath reqEduName = createString("reqEduName");

    public final NumberPath<Long> requiredEduId = createNumber("requiredEduId", Long.class);

    public QRequiredEdu(String variable) {
        super(RequiredEdu.class, forVariable(variable));
    }

    public QRequiredEdu(Path<? extends RequiredEdu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRequiredEdu(PathMetadata metadata) {
        super(RequiredEdu.class, metadata);
    }

}

