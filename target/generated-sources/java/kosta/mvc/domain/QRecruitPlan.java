package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecruitPlan is a Querydsl query type for RecruitPlan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRecruitPlan extends EntityPathBase<RecruitPlan> {

    private static final long serialVersionUID = -1725547581L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecruitPlan recruitPlan = new QRecruitPlan("recruitPlan");

    public final QCompanys company;

    public final QPositions position;

    public final StringPath recruitPlanDetail = createString("recruitPlanDetail");

    public final NumberPath<Long> recruitPlanId = createNumber("recruitPlanId", Long.class);

    public QRecruitPlan(String variable) {
        this(RecruitPlan.class, forVariable(variable), INITS);
    }

    public QRecruitPlan(Path<? extends RecruitPlan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecruitPlan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecruitPlan(PathMetadata metadata, PathInits inits) {
        this(RecruitPlan.class, metadata, inits);
    }

    public QRecruitPlan(Class<? extends RecruitPlan> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompanys(forProperty("company"), inits.get("company")) : null;
        this.position = inits.isInitialized("position") ? new QPositions(forProperty("position")) : null;
    }

}

