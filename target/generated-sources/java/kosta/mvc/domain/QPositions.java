package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPositions is a Querydsl query type for Positions
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPositions extends EntityPathBase<Positions> {

    private static final long serialVersionUID = -1741295706L;

    public static final QPositions positions = new QPositions("positions");

    public final NumberPath<Long> positionId = createNumber("positionId", Long.class);

    public final StringPath positionName = createString("positionName");

    public QPositions(String variable) {
        super(Positions.class, forVariable(variable));
    }

    public QPositions(Path<? extends Positions> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPositions(PathMetadata metadata) {
        super(Positions.class, metadata);
    }

}

