package com.sise.polleria_proyecto.common.application;



public interface IEntityDtoMapper<Entity, RequestDto, ResponseDto> {

    
    public Entity requestToEntity(RequestDto requestDto);
    public ResponseDto entityToResponse(Entity entity);
        
    

}
