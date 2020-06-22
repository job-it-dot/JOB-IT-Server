package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompanyType is a Querydsl query type for CompanyType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyType extends EntityPathBase<CompanyType> {

    private static final long serialVersionUID = 1281113491L;

    public static final QCompanyType companyType = new QCompanyType("companyType");

    public final NumberPath<Long> companyTypeId = createNumber("companyTypeId", Long.class);

    public final StringPath companyTypeName = createString("companyTypeName");

    public QCompanyType(String variable) {
        super(CompanyType.class, forVariable(variable));
    }

    public QCompanyType(Path<? extends CompanyType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompanyType(PathMetadata metadata) {
        super(CompanyType.class, metadata);
    }

}

